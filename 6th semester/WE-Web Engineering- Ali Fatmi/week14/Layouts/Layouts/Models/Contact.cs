using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace Layouts.Models
{
    public class Contact
    {
        [Required]
        public string Name { get; set; }

        [Phone]
        public string PhoneNumber { get; set; }

        [Required, EmailAddress]
        public string Email { get; set; }

        [StringLength(500)]
        public string Message { get; set; }
    }
}