using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Filing_1.Models
{
    public class OrderDetailViewModel
    {
        public int OrderItemId { get; set; }
        public string ProductName { get; set; }
        public int Quantity { get; set; }
        public decimal Price { get; set; }
        public string FilePath { get; set; }
        public string OrderDate { get; set; }
        public string Status { get; set; }
        public string Username { get; set; }
        public string Email { get; set; }
    }
}