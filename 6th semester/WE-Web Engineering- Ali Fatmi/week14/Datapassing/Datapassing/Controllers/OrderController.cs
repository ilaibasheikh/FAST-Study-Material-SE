using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Datapassing.Controllers
{
    public class OrderController : Controller
    {
        //
        // GET: /Order/
        public ActionResult PlaceOrder()
        {
            var orderDetails = new Dictionary<string, object>
    {
        { "OrderId", 123 },
        { "Status", "Processed" }
    };
            TempData["OrderDetails"] = orderDetails;
            return RedirectToAction("OrderSummary");
        }

        public ActionResult OrderSummary()
        {
            return View();
        }

	}
}