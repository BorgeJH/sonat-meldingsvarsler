using System;
using System.Linq;
using Xunit;

namespace Solid.DependencyInversion.Examples
{
    public class DependingOnAbstraction
    {
        [Fact]
        public void Conforming()
        {
            PrintName(Name.From("Alice"));
            PrintSsn(Ssn.From("29033638580"));
        }

        [Fact]
        public void Buggy()
        {
            PrintName(Name.From("29033638580"));
            //PrintSsn(Ssn.From("Alice"));
        }

        void PrintName(Name name)
        {
            
        }

        void PrintSsn(Ssn ssn)
        {
            
        }

        public class Ssn
        {
            public static Ssn From(string ssn)
            {
                return IsValid(ssn)
                    ? new Ssn(ssn)
                    : throw new InvalidOperationException("Invalid ssn");
            }

            static bool IsValid(string ssn)
            {
                return ssn != null && ssn.All(char.IsNumber);
            }

            Ssn(string ssn)
            {
                
            }
        }

        public class Name
        {
            public static Name From(string name)
            {
                return IsValid(name)
                    ? new Name(name)
                    : throw new InvalidOperationException("Invalid name");
            }

            static bool IsValid(string name)
            {
                return !string.IsNullOrWhiteSpace(name);
            }

            Name(string name)
            {
                
            }
        }
    }
}