namespace GeoFinderApi.Models.DTO
{
    public class MapSurveyDTO
    {
        public string documentation { get; set; }
        public List<License> licenses { get; set; }
        public Rate rate { get; set; }
        public List<Result> results { get; set; }
        public Status status { get; set; }
        public StayInformed stay_informed { get; set; }
        public string thanks { get; set; }
        public Timestamp timestamp { get; set; }
        public int total_results { get; set; }
    }

    public class License
    {
        public string name { get; set; }
        public string url { get; set; }
    }

    public class Rate
    {
        public int limit { get; set; }
        public int remaining { get; set; }
        public int reset { get; set; }
    }

    public class Result
    {
        public Annotations annotations { get; set; }
        public Bounds bounds { get; set; }
        public Components components { get; set; }
        public int confidence { get; set; }
        public string formatted { get; set; }
        public Geometry geometry { get; set; }
    }

    public class Annotations
    {
        public DMS DMS { get; set; }
        public string MGRS { get; set; }
        public string Maidenhead { get; set; }
        public Mercator Mercator { get; set; }
        public OSM OSM { get; set; }
        public UN_M49 UN_M49 { get; set; }
        public int callingcode { get; set; }
        public Currency currency { get; set; }
        public string flag { get; set; }
        public string geohash { get; set; }
        public double qibla { get; set; }
        public RoadInfo roadinfo { get; set; }
        public Sun sun { get; set; }
        public Timezone timezone { get; set; }
        public What3Words what3words { get; set; }
    }

    public class DMS
    {
        public string lat { get; set; }
        public string lng { get; set; }
    }

    public class Mercator
    {
        public double x { get; set; }
        public double y { get; set; }
    }

    public class OSM
    {
        public string edit_url { get; set; }
        public string note_url { get; set; }
        public string url { get; set; }
    }

    public class UN_M49
    {
        public Dictionary<string, string> regions { get; set; }
        public List<string> statistical_groupings { get; set; }
    }

    public class Currency
    {
        public string decimal_mark { get; set; }
        public string html_entity { get; set; }
        public string iso_code { get; set; }
        public string iso_numeric { get; set; }
        public string name { get; set; }
        public int smallest_denomination { get; set; }
        public string subunit { get; set; }
        public int subunit_to_unit { get; set; }
        public string symbol { get; set; }
        public int symbol_first { get; set; }
        public string thousands_separator { get; set; }
    }

    public class RoadInfo
    {
        public string drive_on { get; set; }
        public string road { get; set; }
        public string road_type { get; set; }
        public string speed_in { get; set; }
    }

    public class Sun
    {
        public Time rise { get; set; }
        public Time set { get; set; }
    }

    public class Time
    {
        public int apparent { get; set; }
        public int astronomical { get; set; }
        public int civil { get; set; }
        public int nautical { get; set; }
    }

    public class Timezone
    {
        public string name { get; set; }
        public int now_in_dst { get; set; }
        public int offset_sec { get; set; }
        public string offset_string { get; set; }
        public string short_name { get; set; }
    }

    public class What3Words
    {
        public string words { get; set; }
    }

    public class Bounds
    {
        public Northeast northeast { get; set; }
        public Southwest southwest { get; set; }
    }

    public class Northeast
    {
        public double lat { get; set; }
        public double lng { get; set; }
    }

    public class Southwest
    {
        public double lat { get; set; }
        public double lng { get; set; }
    }

    public class Components
    {
        public string ISO_3166_1_alpha_2 { get; set; }
        public string ISO_3166_1_alpha_3 { get; set; }
        public List<string> ISO_3166_2 { get; set; }
        public string _category { get; set; }
        public string _type { get; set; }
        public string city { get; set; }
        public string city_district { get; set; }
        public string continent { get; set; }
        public string country { get; set; }
        public string country_code { get; set; }
        public string county { get; set; }
        public string municipality { get; set; }
        public string postcode { get; set; }
        public string region { get; set; }
        public string road { get; set; }
        public string road_type { get; set; }
        public string state { get; set; }
        public string state_code { get; set; }
        public string state_district { get; set; }
        public string suburb { get; set; }
    }

    public class Status
    {
        public int code { get; set; }
        public string message { get; set; }
    }

    public class StayInformed
    {
        public string blog { get; set; }
        public string mastodon { get; set; }
    }

    public class Timestamp
    {
        public string created_http { get; set; }
        public int created_unix { get; set; }
    }

    public class Geometry
    {
        public decimal Lat { get; set; }
        public decimal Lng { get; set; }
    }

}
