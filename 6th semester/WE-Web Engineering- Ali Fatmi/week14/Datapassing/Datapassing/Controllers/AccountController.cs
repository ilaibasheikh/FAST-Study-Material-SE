using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Datapassing.Controllers
{
    public class AccountController : Controller
    {
        //
        // GET: /Account/
        public ActionResult Login()
        {
            // Setting session data
            Session["UserName"] = "JohnDoe";
            Session["IsLoggedIn"] = true;

            return RedirectToAction("Dashboard");
        }

        public ActionResult Dashboard()
        {
            return View();
        }
        public ActionResult Logout()
        {
          
            Session.Clear();      // Optional: remove all keys
            Session.Abandon();    // Optional: abandon session

            return RedirectToAction("Login", "Account");
        }


	}
}