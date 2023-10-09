import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http'; // Import HttpClient

@Component({
  selector: 'app-survey',
  templateUrl: './survey.component.html',
  styleUrls: ['./survey.component.css']
})
export class SurveyComponent {
  // Define your surveyForm here

  constructor(private http: HttpClient) {} // Inject HttpClient in the constructor
  latitude:any;
  longitude:any;
  zoom:any;
  base64 = '';
  Find() {
    debugger;

    // Create the URL with the form values
    const url = `https://localhost:7146/v1/GetMap/Latitude/${this.latitude}/Longitude/${this.longitude}/Zoom/${this.zoom}`;

    // Make the HTTP GET request
    this.http.get(url).subscribe((data:any) => {
      // Handle the response data here
      this.base64 = data.base64Map
      debugger;
      console.log(data);
    }, (error) => {
      // Handle any errors here
      console.error(error);
    });
  }
}
