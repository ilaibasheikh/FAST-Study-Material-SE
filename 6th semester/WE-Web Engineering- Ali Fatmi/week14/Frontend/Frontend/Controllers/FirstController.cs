using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Frontend.Models;

namespace Frontend.Controllers
{
    public class FirstController : Controller
    {
        //
        // GET: /First/
        public ActionResult Index()
        {
            return View();
        }
        [HttpPost]
        public ActionResult SubmitForm(FormCollection form)
        {
            string name = form["name"];
            string email = form["email"];
            string gender = form["gender"];
            string course = form["course"];
            bool agreed = form["agree"].StartsWith("true");

            ViewBag.Message = "Form submitted successfully!";
            return View();
        }

        [HttpGet]
        public ActionResult Register()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Register(Student student)
        {
            if (ModelState.IsValid)
            {
                // Save to DB (omitted)
                ViewBag.Message = "Student registered successfully!";
                return View("Register");
            }

            return View(student);
        }
        [HttpGet]
        public ActionResult Add()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Add(Product product)
        {
            if (ModelState.IsValid)
            {
                return View("ProductDetails", product);
            }

            return View(product);
        }
	}
}