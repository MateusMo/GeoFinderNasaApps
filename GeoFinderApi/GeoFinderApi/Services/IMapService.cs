namespace GeoFinderApi.Services
{
    public interface IMapService
    {
        public Task<string> GetMap(int Zoom, decimal Latitude, decimal Longitude);

    }
}
