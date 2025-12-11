using Microsoft.AspNetCore.Mvc;


namespace PersonalFinanceTracker.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Intro()
        {
            ViewData["Title"] = "Introduction";
            return View();
        }


        public IActionResult Architecture()
        {
            ViewData["Title"] = "Architecture";
            return View();
        }


        public IActionResult AzureServices()
        {
            ViewData["Title"] = "Azure Services";
            return View();
        }
    }
}