import { Component } from '@angular/core';

@Component({
  selector: 'app-movie-title',
  templateUrl: './movie-title.component.html',
  styleUrls: ['./movie-title.component.css']
})
export class MovieTitleComponent {

  title = '';
  
  examplePerson: any = {
    firstName: '',
    lastName: ''
  };

  changePerson = () => {
    this.examplePerson = {
      firstName: 'default',
      lastName: 'person'
    }
  }

}
