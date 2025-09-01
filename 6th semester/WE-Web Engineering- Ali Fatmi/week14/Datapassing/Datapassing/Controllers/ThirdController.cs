using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Datapassing.Controllers
{
    public class ThirdController : Controller
    {
        //
        // GET: /Third/
        public ActionResult SetTempData()
        {
            TempData["Message"] = "This is a temporary message.";
            return RedirectToAction("DisplayTempData");
        }

        public ActionResult DisplayTempData()
        {
            return View();
        }
        public ActionResult ShowNotification()
        {
            return View();
        }

        public ActionResult ConfirmNotification()
        {
            var notification = TempData.Peek("Notification");
            return View((object)notification);
        }


	}
}