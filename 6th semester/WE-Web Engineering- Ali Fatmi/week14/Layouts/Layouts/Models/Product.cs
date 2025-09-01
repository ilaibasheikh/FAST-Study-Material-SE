using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace Layouts.Models
{
    public class Product
    {
        [Required]
        public string Name { get; set; }

        [Range(1, 10000)]
        public decimal Price { get; set; }

        public string Category { get; set; }
    }
}