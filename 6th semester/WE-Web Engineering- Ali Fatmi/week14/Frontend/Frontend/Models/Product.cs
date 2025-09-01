using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace Frontend.Models
{

    public class Product
    {
        [Required]
        public string Name { get; set; }

        [Required]
        public decimal Price { get; set; }

        public string Category { get; set; }
    }
}