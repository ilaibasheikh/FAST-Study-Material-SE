using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Xml;

namespace APIS_1.Controllers
{
    public class Home1Controller : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult GetWeatherFromSoap(string city)
        {
            if (string.IsNullOrWhiteSpace(city))
            {
                city = "London"; // Default
            }

            var service = new WeatherService();
            XmlDocument weatherXml = service.GetWeather(city);

            // Extract data from XML
            var cityName = weatherXml.SelectSingleNode("//City")?.InnerText;
            var temperature = weatherXml.SelectSingleNode("//Temperature")?.InnerText;
            var wind = weatherXml.SelectSingleNode("//Wind")?.InnerText;
            var description = weatherXml.SelectSingleNode("//Description")?.InnerText;

            ViewBag.City = cityName;
            ViewBag.Temp = temperature;
            ViewBag.Wind = wind;
            ViewBag.Description = description;

            return View();
        }
    }
}