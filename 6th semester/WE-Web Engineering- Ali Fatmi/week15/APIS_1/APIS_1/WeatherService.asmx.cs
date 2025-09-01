using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Xml;
using System.Net;
using Newtonsoft.Json.Linq;


namespace APIS_1
{
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    public class WeatherService : WebService
    {
        [WebMethod]
        public XmlDocument GetWeather(string city)
        {
            XmlDocument doc = new XmlDocument();

            if (string.IsNullOrWhiteSpace(city))
            {
                city = "London";
            }

            // ✅ Live API call
            string apiUrl = $"https://goweather.herokuapp.com/weather/{city}";

            ServicePointManager.SecurityProtocol = SecurityProtocolType.Tls12;

            using (var client = new WebClient())
            {
                try
                {
                    var response = client.DownloadString(apiUrl);
                    var data = JObject.Parse(response);

                    string temperature = data["temperature"]?.ToString() ?? "N/A";
                    string wind = data["wind"]?.ToString() ?? "N/A";
                    string description = data["description"]?.ToString() ?? "N/A";

                    // Create XML
                    string xml = $@"
                        <Weather>
                            <City>{city}</City>
                            <Temperature>{temperature}</Temperature>
                            <Wind>{wind}</Wind>
                            <Description>{description}</Description>
                        </Weather>";

                    doc.LoadXml(xml);
                }
                catch
                {
                    // Error XML
                    string errorXml = $@"
                        <Weather>
                            <City>{city}</City>
                            <Temperature>Unknown</Temperature>
                            <Wind>Unknown</Wind>
                            <Description>Could not fetch data.</Description>
                        </Weather>";
                    doc.LoadXml(errorXml);
                }
            }

            return doc;
        }
    }

}
