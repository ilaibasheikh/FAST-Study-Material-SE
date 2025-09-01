using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Layouts.Models;

namespace Layouts.Controllers
{
    public class AccountController : Controller
    {
        MyDbContext db = new MyDbContext();
        
        public ActionResult Login()
        {
            Console.WriteLine("Login page accessed.");
            return View();
        }
        [HttpPost]
        public ActionResult Login(string username, string password)
        {
           // var users = db.Users.ToList();
           
             var user = db.Users.FirstOrDefault(u => u.Username == username && u.Password == password);

            if (user != null)
            {
                Session["Username"] = user.Username;
                Session["Role"] = user.Role;

                if (user.Role == "Admin")
                    return RedirectToAction("Index", "Home");
                else
                    return RedirectToAction("home", "Home");
            }

            ViewBag.Message = "Invalid credentials";
          
            return View();
        }
        public ActionResult Logout()
        {
            Session.Clear();
            Session.Abandon();
            return RedirectToAction("Login");
        }
	}
}