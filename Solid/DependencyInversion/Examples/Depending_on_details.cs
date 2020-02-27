using Xunit;

namespace Solid.DependencyInversion.Examples
{
    public class DependingOnDetails
    {
        #region Primitive obsession

        [Fact]
        public void Fragile_strings()
        {
            PrintName("29033638580");
            PrintSsn("Alice");
        }

        void PrintSsn(string ssn)
        {
            
        }

        void PrintName(string name)
        {
            
        }

        #endregion

        #region Details leaking into abstraction

        interface IRenderEngine
        {
            string Render(RazorTemplate template);
        }

        class RazorTemplate { }

        #region Implementations

        class RazorRenderEngine : IRenderEngine {
            public string Render(RazorTemplate template)
            {
                return template.GetType().Name;
            }
        }

        class HtmlRenderEngine : IRenderEngine {
            public string Render(RazorTemplate template)
            {
                return template.GetType().Name;
            }
        }

        class MarkdownRenderEngine : IRenderEngine {
            public string Render(RazorTemplate template)
            {
                return template.GetType().Name;
            }
        }

        #endregion

        #endregion
    }
}