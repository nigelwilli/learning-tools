import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  showStructuralDirectives = false;
  showAttributeDirectives = false;
  showPipes = false;

  show(whatToShow: string) {
    switch(whatToShow) {
      case 'structural':
        this.showPipes = false
        this.showAttributeDirectives = false;
        this.showStructuralDirectives = true;
        break;
      case 'attribute':
        this.showPipes = false
        this.showStructuralDirectives = false;
        this.showAttributeDirectives = true;
        break;
      case 'pipes':
        this.showPipes = true;
        this.showStructuralDirectives = false;
        this.showAttributeDirectives = false;
        break;
      default:
        this.showPipes = false
        this.showAttributeDirectives = false;
        this.showStructuralDirectives = false;
    }
  }
}
