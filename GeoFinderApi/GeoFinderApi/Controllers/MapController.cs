using GeoFinderApi.Models.DTO;
using GeoFinderApi.Services;
using Microsoft.AspNetCore.Mvc;

namespace GeoFinderApi.Controllers
{
    [ApiController]
    public class MapController : ControllerBase
    {
        private IMapService _mapService;
        private IInfoService _infoService;
        public MapController(IMapService mapService,IInfoService iInfoservice)
        {
            _mapService = mapService;   
            _infoService = iInfoservice;
        }

        [Route("/v1/GetMap/Latitude/{lat}/Longitude/{lon}/Zoom/{zoom}")]
        [HttpGet]
        public async Task<IActionResult> GetMap(decimal lat, decimal lon, int zoom)
        {
            try
            {
                var Base64Map = await _mapService
                    .GetMap(zoom,lat,lon);
                
                var MapSurveyDTO = await _infoService.GetMap(lat, lon);

                var ProcessedDTO = new ProcessedDTO()
                {
                    Base64Map = Base64Map,
                    MapSurveyDTO = MapSurveyDTO
                };

                return Ok(ProcessedDTO);
            }
            catch (Exception)
            {

                throw;
            }
        }
    }
}
