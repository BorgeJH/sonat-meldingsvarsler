using System;
using System.Collections.Generic;
using Xunit;

namespace Solid.OpenClosed.Demo
{
    public class OpenClosedWithDependencyContainer
    {
        [Fact]
        public void DependencyInjection()
        {
            var container = new Container();
            container.Use<ISmsSender, EmailSmsSender>();

            Assert.IsType<EmailSmsSender>(container.Resolve<ISmsSender>());
        }

        [Fact]
        public void Switch_from_email_to_rest()
        {
            var container = new Container();
            container.Use<ISmsSender, EmailSmsSender>();
            //container.Use<ISmsSender, RestSmsSender>();

            //Assert.IsType<RestSmsSender>(container.Resolve<ISmsSender>());
        }

        class EmailSmsSender : ISmsSender
        {
        }

        class RestSmsSender : ISmsSender
        {
        }

        interface ISmsSender
        {
        }

        class Container
        {
            readonly Dictionary<Type, Type> implementationsByContract = new Dictionary<Type, Type>();

            public void Use<TContract, TImplementation>()
                where TImplementation : TContract
            {
                implementationsByContract.Add(typeof(TContract), typeof(TImplementation));
            }

            public TContract Resolve<TContract>()
            {
                var type = implementationsByContract[typeof(TContract)];
                return (TContract) Activator.CreateInstance(type);
            }
        }
    }
}