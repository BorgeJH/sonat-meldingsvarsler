using System;
using System.Collections.Generic;
using System.Linq;
using Xunit;

namespace Solid.OpenClosed.Examples
{
    public class OpenClosedWithSimilarActions
    {
        public class Violating
        {
            [Fact]
            public void Send_to_back_office()
            {
                var order = new Order();
                order.Send();
                //Cannot even verify
            }

            [Fact]
            public void Also_send_receipt()
            {
                var order = new Order();
                order.Send();
                //Cannot even verify
            }

            [Fact]
            public void Also_notify_shipping()
            {
                var order = new Order();
                order.Send();
                //Cannot even verify
            }

            class Order : IOrder
            {
                public void Send()
                {
                    new BackOffice().Send(this);
                    new Receipt().Send(this);
                    new Shipping().Send(this);
                }
            }
        }

        public class Conforming
        {
            [Fact]
            public void Send_to_back_office()
            {
                var order = new Order();
                var sender = new OrderSender();
                var summary = sender.Send(order);
                Assert.Contains(typeof(BackOffice), summary.Recipients);
            }

            [Fact]
            public void Also_send_receipt()
            {
                var order = new Order();
                var sender = new OrderSender();
                var summary = sender.Send(order);
                Assert.Contains(typeof(BackOffice), summary.Recipients);
                Assert.Contains(typeof(Receipt), summary.Recipients);
            }

            [Fact]
            public void Also_notify_shipping()
            {
                var order = new Order();
                var sender = new OrderSender();
                var summary = sender.Send(order);
                Assert.Contains(typeof(BackOffice), summary.Recipients);
                Assert.Contains(typeof(Receipt), summary.Recipients);
                Assert.Contains(typeof(Shipping), summary.Recipients);
            }

            class OrderSender
            {
                readonly List<ISender> senders = new List<ISender>();

                public OrderSender()
                {
                    senders.Add(new BackOffice());
                    senders.Add(new Receipt());
                    senders.Add(new Shipping());
                }

                public Summary Send(IOrder order)
                {
                    foreach (var sender in senders)
                    {
                        sender.Send(order);
                    }

                    return new Summary(senders);
                }
            }

            class Order : IOrder
            {
            }

            class Summary
            {
                public Summary(List<ISender> senders)
                {
                    Recipients = senders.Select(sender => sender.GetType());
                }

                public IEnumerable<Type> Recipients { get; }
            }
        }

        #region Stuff

        interface IOrder
        {
        }

        interface ISender
        {
            void Send(IOrder order);
        }

        class BackOffice : ISender
        {
            public void Send(IOrder order)
            {
                Console.Out.WriteLine("Sending " + order);
            }
        }

        class Receipt : ISender
        {
            public void Send(IOrder order)
            {
                Console.Out.WriteLine("Sending " + order);
            }
        }

        class Shipping : ISender
        {
            public void Send(IOrder order)
            {
                Console.Out.WriteLine("Sending " + order);
            }
        }

        #endregion
    }
}
