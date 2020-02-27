using System;
using Xunit;

namespace Solid.OpenClosed.Demo
{
    public class OpenClosedWithComposition
    {
        [Fact]
        public void Composition()
        {
            var car = new Car();
            var mc = new MotorCycle();

            Assert.Equal(5_000, car.MaxRpm());
            Assert.Equal(12_000, mc.MaxRpm());
        }

        [Fact]
        public void Introduce_electric_vehicle()
        {
            //var ev = new ElectricVehicle();
            //Assert.Equal(18_000, ev.MaxRpm());
        }

        class Vehicle
        {
            readonly ITransmission transmission;
            readonly IEngine engine;

            protected Vehicle(ITransmission transmission, IEngine engine)
            {
                this.transmission = transmission;
                this.engine = engine;
            }

            public int MaxRpm() => transmission.CapRpm(engine.MaxRpm());
        }

        class MotorCycle : Vehicle
        {
            public MotorCycle() : base(new ChainTransmission(), new TwoCylinderEngine500Cc())
            {
            }
        }

        class Car : Vehicle
        {
            public Car() : base(new FourWheelTransmission(), new SixCylinderEngine200Hp())
            {
            }
        }

        interface IEngine
        {
            int MaxRpm();
        }

        interface ITransmission
        {
            int CapRpm(int rpm);
        }

        class TwoCylinderEngine500Cc : IEngine
        {
            public int MaxRpm() => 20_000;
        }

        class ChainTransmission : ITransmission
        {
            public int CapRpm(int rpm) => Math.Min(12_000, rpm);
        }

        class SixCylinderEngine200Hp : IEngine
        {
            public int MaxRpm() => 10_000;
        }

        class FourWheelTransmission : ITransmission
        {
            public int CapRpm(int rpm) => Math.Min(5_000, rpm);
        }

        class ElectricMotor100kW : IEngine
        {
            public int MaxRpm() => 20_000;
        }
    }
}