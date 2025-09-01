using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web;
using System.ComponentModel.DataAnnotations;
namespace Layouts.Models
{
    public class Order
    {
        public int OrderId { get; set; }

        [Required]
        public string CustomerName { get; set; }

        [DataType(DataType.Date)]
        public DateTime OrderDate { get; set; }
    }
}