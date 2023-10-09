using GeoFinderApi.Models.DTO;
using Microsoft.AspNetCore.Http.HttpResults;
using System.Net.Http;
using System.Text.Json;

namespace GeoFinderApi.Services
{
    public class InfoService : IInfoService
    {
        public async Task<MapSurveyDTO> GetMap(decimal Latitude, decimal Longitude)
        {
            var apiUrl = $"https://api.opencagedata.com/geocode/v1/json?q={Longitude}+{Latitude}&key=5b03e65c816e46d8af36612edce06823";

            try
            {
                using (HttpClient httpClient = new HttpClient())
                {
                    HttpResponseMessage response = await httpClient.GetAsync(apiUrl);

                    string jsonResponse = await response.Content.ReadAsStringAsync();

                    var responseParsed = JsonSerializer.Deserialize<MapSurveyDTO>(jsonResponse);

                    return responseParsed;
                }
            }
            catch (Exception ex)
            {
                throw ex;
            }
        }
    }
}
