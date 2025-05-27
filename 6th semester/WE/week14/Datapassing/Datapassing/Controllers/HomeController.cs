using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Datapassing.Controllers
{
    public class HomeController : Controller
    {
        //
        // GET: /Home/
        public ActionResult Index()
        {
            // Adding data to ViewData
            ViewData["Title"] = "Welcome to ASP.NET MVC";
            ViewData["Items"] = new List<string> { "Item 1", "Item 2", "Item 3" };
            return View();
        }

        public ActionResult Index2()
        {
            // Adding data to ViewData
            ViewData["ProductName"] = "Laptop";
            ViewData["Price"] = 1500.75;
            ViewData["IsAvailable"] = true;
            return View();

        }


	}

}