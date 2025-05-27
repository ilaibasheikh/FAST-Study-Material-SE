using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;

namespace Layouts.Models
{
    public class MyDbContext : DbContext
    {
        public MyDbContext() : base("DefaultConnection") {
            
        }

        public DbSet<User> Users { get; set; }
    }
}
