using GeoFinderApi.Models.DTO;

namespace GeoFinderApi.Services
{
    public interface IInfoService
    {
        public Task<MapSurveyDTO> GetMap(decimal Latitude, decimal Longitude);
    }
}
