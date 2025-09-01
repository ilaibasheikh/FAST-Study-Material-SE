using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Datapassing.Controllers
{
    public class SecondController : Controller
    {
        //
        // GET: /Second/
        public ActionResult Index()
        {
            // Adding data to ViewBag
            ViewBag.Title = "Welcome to ASP.NET MVC";
            ViewBag.Message = "This is a dynamic message using ViewBag.";

            return View();
        }
        public ActionResult Index2()
        {
            ViewBag.ProductName = "Laptop";
            ViewBag.Price = 1500.75;
            ViewBag.Features = new List<string> { "16GB RAM", "512GB SSD", "Intel i7 Processor" };


            return View();
        }
        public ActionResult Status()
        {
            ViewBag.IsLoggedIn = true;
            ViewBag.UserName = "John Doe";

            return View();
        }


	}
}