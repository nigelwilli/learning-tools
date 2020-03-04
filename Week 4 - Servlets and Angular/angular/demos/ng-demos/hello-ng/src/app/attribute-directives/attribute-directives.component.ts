import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-attribute-directives',
  templateUrl: './attribute-directives.component.html',
  styleUrls: ['./attribute-directives.component.css']
})
export class AttributeDirectivesComponent {

  isDisabled = true;
  name = 'something';
  selectedColor = 'green';
  colors = ['red', 'orange', 'yellow', 'green', 'blue', 'indigo', 'violet'];
  
  classes = [
    {
      className: 'font-weight-bold',
      displayName: 'bold'
    },
    {
      className: 'font-italic',
      displayName: 'italic'
    },
    {
      className: 'mark',
      displayName: 'highlight'
    }  
  ];

  selectedClasses = [];

  enabler() {
    this.isDisabled = !this.isDisabled;
  }

  addClass($event) {
    console.log($event);
    this.selectedClasses = [];

    for(let option of $event.target.selectedOptions) {
      this.selectedClasses.push(option.value);
    }

    console.log(this.selectedClasses);
    
  }

}
