using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Datapassing.Controllers
{
    public class CartController : Controller
    {
        //
        // GET: /Cart/
        public ActionResult AddToCart()
        {
            var cart = new List<string> { "Laptop", "Mouse", "Keyboard" };
            Session["CartItems"] = cart;

            return RedirectToAction("ViewCart");
        }

        public ActionResult ViewCart()
        {
            return View();
        }

	}
}