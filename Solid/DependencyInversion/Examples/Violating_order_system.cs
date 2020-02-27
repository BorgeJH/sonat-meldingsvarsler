using System;
using System.Collections.Generic;
using System.Linq;
using Xunit;

namespace Solid.DependencyInversion.Examples
{
    public class ViolatingOrderSystem
    {
        [Fact]
        public void Find_delayed_orders()
        {
            var orders = new OrderBook();
            orders.Prepare(new Order(DateTime.Today).With(new Product(1)));
            orders.Prepare(new Order(DateTime.Today).With(new Product(101)));

            var statistics = new OrderStatistics(orders);

            var count = statistics.CountDueOrders(
                DateTime.Today);

            Assert.Equal(1, count);
        }

        #region Order system

        class OrderStatistics
        {
            readonly OrderBook book;

            public OrderStatistics(OrderBook book)
            {
                this.book = book;
            }

            public int CountDueOrders(DateTime dueDate)
            {
                var ordersDue = book.Orders.Where(order => order.ShippingDate <= dueDate);
                var withUnavailableProducts = ordersDue.Where(ProductsAreUnavailable);
                return withUnavailableProducts.Count();
            }

            bool ProductsAreUnavailable(Order order)
            {
                var inventory = new Inventory();
                return order.Products.Any(product => inventory.OutOfStock(product));
            }
        }

        class OrderBook
        {
            public List<Order> Orders { get; } = new List<Order>();

            public void Prepare(Order order)
            {
                Orders.Add(order);
            }
        }

        class Order
        {
            public List<Product> Products { get; } = new List<Product>();
            public DateTime ShippingDate { get; }

            public Order(DateTime shippingDate)
            {
                ShippingDate = shippingDate;
            }

            public Order With(Product product)
            {
                Products.Add(product);
                return this;
            }

        }

        class Product
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
    }

    #endregion
}