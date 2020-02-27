using System;
using System.Collections.Generic;
using Xunit;

namespace Solid.OpenClosed.Demo
{
    public class OpenClosedWithFeatureFlags
    {
        [Fact]
        public void FeatureFlags()
        {
            var container = new Container();
            var feature = new FeatureFlag(false);

            feature.Toggle(
                @on: () => container.Use<ISmsSender, RestSmsSender>(),
                off: () => container.Use<ISmsSender, EmailSmsSender>());

            var sender = container.Resolve<ISmsSender>();

            Assert.IsType<EmailSmsSender>(sender);
        }

        [Fact]
        public void Turn_feature_on()
        {
            var container = new Container();
            var feature = new FeatureFlag(isOn: false);

            feature.Toggle(
                @on: () => container.Use<ISmsSender, RestSmsSender>(),
                off: () => container.Use<ISmsSender, EmailSmsSender>());

            var sender = container.Resolve<ISmsSender>();

            //Assert.IsType<RestSmsSender>(sender);
        }

        #region Stuff

        class FeatureFlag
        {
            readonly bool isOn;

            public FeatureFlag(bool isOn)
            {
                this.isOn = isOn;
            }

            public void Toggle(Action on, Action off = null)
            {
                if (isOn)
                {
                    on?.Invoke();
                }
                else
                {
                    off?.Invoke();
                }
            }
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

        #endregion
    }
}