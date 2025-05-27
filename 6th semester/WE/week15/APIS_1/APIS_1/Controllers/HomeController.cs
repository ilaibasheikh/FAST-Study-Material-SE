using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Net;
using Newtonsoft.Json.Linq;

namespace APIS_1.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

      
        public ActionResult GetWeather(string city)
        {
            if (string.IsNullOrWhiteSpace(city))
            {
                city = "London"; // Default city
            }

            string weatherUrl = string.Format("https://goweather.herokuapp.com/weather/{0}",city);

            ServicePointManager.SecurityProtocol = SecurityProtocolType.Tls12;

            using (var client = new WebClient())
            {
                var response = client.DownloadString(weatherUrl);
                var data = JObject.Parse(response);

                ViewBag.City = city;
                ViewBag.Temp = data["temperature"];
                ViewBag.Wind = data["wind"];
                ViewBag.Description = data["description"];
            }

            return View();
        }
    }
}