using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using Filing_1.Models;
using System.IO;

namespace Filing_1.Controllers
{
    public class OrderItemController : Controller
    {
        private DB_FileEntities db = new DB_FileEntities();

        // GET: /OrderItem/
        public ActionResult Index()
        {
            var orderitems = db.OrderItems.Include(o => o.Order);
            return View(orderitems.ToList());
        }

        // GET: /OrderItem/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            OrderItem orderitem = db.OrderItems.Find(id);
            if (orderitem == null)
            {
                return HttpNotFound();
            }
            return View(orderitem);
        }

        // GET: /OrderItem/Create
        public ActionResult Create()
        {
            ViewBag.OrderId = new SelectList(db.Orders, "OrderId", "Status");
            return View();
        }

        // POST: /OrderItem/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(OrderItem orderitem, HttpPostedFileBase file)
        {
            if (ModelState.IsValid)
            {
                if (file != null && file.ContentLength > 0)
                {
                    var fileName = Path.GetFileName(file.FileName);
                    var path = Path.Combine(Server.MapPath("~/Uploads"), fileName);
                    file.SaveAs(path);
                    orderitem.FilePath = "/Uploads/" + fileName;
                }

                db.OrderItems.Add(orderitem);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.OrderId = new SelectList(db.Orders, "OrderId", "Status", orderitem.OrderId);
            return View(orderitem);
        }

        // GET: /OrderItem/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            OrderItem orderitem = db.OrderItems.Find(id);
            if (orderitem == null)
            {
                return HttpNotFound();
            }
            ViewBag.OrderId = new SelectList(db.Orders, "OrderId", "Status", orderitem.OrderId);
            return View(orderitem);
        }

        // POST: /OrderItem/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(OrderItem orderitem, HttpPostedFileBase file)
        {
            if (ModelState.IsValid)
            {
                if (file != null && file.ContentLength > 0)
                {
                    string fileName = Path.GetFileName(file.FileName);
                    string uploadPath = Server.MapPath("~/Uploads/");
                    string fullPath = Path.Combine(uploadPath, fileName);
                    file.SaveAs(fullPath);
                    orderitem.FilePath = "~/Uploads/" + fileName;
                }
                else
                {
                    // Keep the original file path
                    db.Entry(orderitem).Property(x => x.FilePath).IsModified = false;
                }

                db.Entry(orderitem).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.OrderId = new SelectList(db.Orders, "OrderId", "Status", orderitem.OrderId);
            return View(orderitem);
        }

        // GET: /OrderItem/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            OrderItem orderitem = db.OrderItems.Find(id);
            if (orderitem == null)
            {
                return HttpNotFound();
            }
            return View(orderitem);
        }

        // POST: /OrderItem/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            OrderItem orderitem = db.OrderItems.Find(id);
            db.OrderItems.Remove(orderitem);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Editnew(OrderItem orderitem, HttpPostedFileBase file)
        {
            if (ModelState.IsValid)
            {
                if (file != null && file.ContentLength > 0)
                {
                    string extension = Path.GetExtension(file.FileName).ToLower();
                    int fileSize = file.ContentLength;

                    // Validate image files
                    if ((extension == ".png" || extension == ".jpg" || extension == ".jpeg") && fileSize <= 2 * 1024 * 1024)
                    {
                        string fileName = Path.GetFileName(file.FileName);
                        string path = Path.Combine(Server.MapPath("~/App_Data/"), fileName);
                        file.SaveAs(path);
                        orderitem.FilePath = "~/App_Data/" + fileName;
                    }
                    // Validate Word or PDF files
                    else if ((extension == ".pdf" || extension == ".doc" || extension == ".docx") && fileSize <= 5 * 1024 * 1024)
                    {
                        string fileName = Path.GetFileName(file.FileName);
                        string path = Path.Combine(Server.MapPath("~/App_Data/"), fileName);
                        file.SaveAs(path);
                        orderitem.FilePath = "~/App_Data/" + fileName;
                    }
                    else
                    {
                        ModelState.AddModelError("", "Invalid file type or size.");
                        ViewBag.OrderId = new SelectList(db.Orders, "OrderId", "Status", orderitem.OrderId);
                        return View(orderitem);
                    }
                }

                db.Entry(orderitem).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.OrderId = new SelectList(db.Orders, "OrderId", "Status", orderitem.OrderId);
            return View(orderitem);
        }

    }
}
