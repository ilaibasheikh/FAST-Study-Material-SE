using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace Layouts.Models
{
    public class Employee
    {
        public int Id { get; set; }

        [Required, StringLength(50)]
        public string FullName { get; set; }

        [Range(18, 60)]
        public int Age { get; set; }

        [Required]
        public string Department { get; set; }
    }
}