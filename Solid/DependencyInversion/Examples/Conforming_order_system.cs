using System;
using System.Collections.Generic;
using System.Linq;
using Xunit;

namespace Solid.DependencyInversion.Examples
{
    public class ConformingOrderSystem
    {
        [Fact]
        public void Find_delayed_orders()
        {
            var orders = new OrderBook();
            var inventory = new Inventory();

            orders.Prepare(new Order(DateTime.Today).With(new Product(1)));
            orders.Prepare(new Order(DateTime.Today).With(new Product(101)));

            var statistics = new OrderStatistics(orders);

            var count = statistics.CountDueOrders(DateTime.Today, inventory);

            Assert.Equal(1, count);
        }

        interface IOrderSearch
        {
            IEnumerable<Order> FindBy(IOrderSpecification specification);
        }

        interface IOrderSpecification
        {
            bool IsSatisfied(Order order);
        }

        #region Order system

        class OrderStatistics
        {
            readonly IOrderSearch orders;

            public OrderStatistics(IOrderSearch orders)
            {
                this.orders = orders;
            }

            public int CountDueOrders(DateTime dueDate, Inventory inventory)
            {
                var specification = Specification.DueToOutOfStock(dueDate, inventory);
                return orders.FindBy(specification).Count();
            }
        }

        class OrderBook : IOrderSearch
        {
            readonly List<Order> orders = new List<Order>();

            public void Prepare(Order order)
            {
                orders.Add(order);
            }

            public IEnumerable<Order> FindBy(IOrderSpecification specification)
            {
                return orders.Where(specification.IsSatisfied);
            }
        }

        public class Order
        {
            readonly List<Product> products = new List<Product>();

            public IEnumerable<Product> Products => products.AsEnumerable();

            public DateTime ShippingDate { get; }

            public Order(DateTime shippingDate)
            {
                ShippingDate = shippingDate;
            }

            public Order With(Product product)
            {
                products.Add(product);
                return this;
            }

        }

        public class Product
        {
            public Product(int id)
            {
                Id = id;
            }

            public int Id { get; }
        }

        class Inventory
        {
            public bool OutOfStock(Product product)
            {
                return product.Id < 10;
            }
        }

        #endregion

        #region Concrete specifications

        static class Specification
        {
            public static IOrderSpecification DueToOutOfStock(
                DateTime dueDate, Inventory inventory)
            {
                return new And(
                    new DueDateSpecification(dueDate), 
                    new OutOfStockSpecification(inventory));
            }

            class And : IOrderSpecification
            {
                readonly IOrderSpecification[] specifications;

                public And(params IOrderSpecification[] specifications)
                {
                    this.specifications = specifications;
                }

                public bool IsSatisfied(Order order)
                {
                    return specifications.All(s => s.IsSatisfied(order));
                }
            }
        }

        class DueDateSpecification : IOrderSpecification
        {
            readonly DateTime dueDate;

            public DueDateSpecification(in DateTime dueDate)
            {
                this.dueDate = dueDate;
            }

            public bool IsSatisfied(Order order) => order.ShippingDate <= dueDate;
        }

        class OutOfStockSpecification : IOrderSpecification
        {
            readonly Inventory inventory;

            public OutOfStockSpecification(Inventory inventory)
            {
                this.inventory = inventory;
            }

            public bool IsSatisfied(Order order)
            {
                return order.Products.Any(product => inventory.OutOfStock(product));
            }
        }

        #endregion
    }
}