
namespace GeoFinderApi.Services
{
    public class MapService : IMapService
    {
        public async Task<string> GetMap(int Zoom, decimal Latitude, decimal Longitude)
        {
            var apiUrl = $"https://api.mapbox.com/styles/v1/mapbox/satellite-v9/static/{Latitude},{Longitude},{Zoom}/600x600?access_token=pk.eyJ1IjoibWF0ZXVzbW8iLCJhIjoiY2xuZzkwMTV5MDFkZzJrcWlrZzVpOGZxdSJ9.u_eWIughBAP6VDwfL0x7sA";
            //var apiUrl = $"https://api.nasa.gov/planetary/earth/imagery?lon={Longitude}lat={Latitude}&date=2018-01-01&dim={Zoom}&api_key=DjZjo1eS39TClplayd7uSE6HgPiM56cFi7hlqPHA"
        
            try
            {
                using (HttpClient httpClient = new HttpClient())
                {
                    HttpResponseMessage response = await httpClient.GetAsync(apiUrl);

                    byte[] imageBytes = await response.Content.ReadAsByteArrayAsync();

                    string base64String = Convert.ToBase64String(imageBytes);

                    return "data:image/png;base64,"+base64String;
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"An error occurred: {ex.Message}");
                return "";
            }
        }

    }
}
