using System.Collections.Generic;
using System.Linq;
using Xunit;

namespace Solid.OpenClosed.Examples
{
    public class OpenClosedWithStrategy
    {
        [Fact]
        public void Start_car_pool_violating()
        {
            var car = new Car();
            var truck = new Truck();
            var pool = new object[]{car, truck};
            
            StartAllViolating(pool);

            Assert.True(car.Running);
            Assert.True(truck.Idle);
        }

        [Fact]
        public void Start_car_pool_conforming()
        {
            var car = new Car();
            var truck = new Truck();
            var pool = new object[]{car, truck};
            
            StartAllConforming(pool);

            Assert.True(car.Running);
            Assert.True(truck.Idle);
        }

        void StartAllViolating(IEnumerable<object> pool)
        {
            foreach (var car in pool)
            {
                switch (car)
                {
                    case Car c: 
                        c.PushButton();
                        break;
                    case Truck t: 
                        t.TurnKey();
                        break;
                }
            }
        }

        void StartAllConforming(IEnumerable<object> pool)
        {
            foreach (var startable in pool.OfType<IStartable>())
            {
                startable.Start();
            }
        }

        #region Stuff

        interface IStartable
        {
            void Start();
        }

        class Truck : IStartable
        {
            public bool Idle { get; private set; }

            public void TurnKey()
            {
                Idle = true;
            }

            public void Start() => TurnKey();
        }

        class Car : IStartable
        {
            public bool Running { get; private set; }

            public void PushButton()
            {
                Running = true;
            }

            public void Start() => PushButton();
        }

        #endregion
    }
}