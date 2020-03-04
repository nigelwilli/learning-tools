import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-structural-directives',
  templateUrl: './structural-directives.component.html',
  styleUrls: ['./structural-directives.component.css']
})
export class StructuralDirectivesComponent {

  condition: boolean = false;

  changeCondition() {
    this.condition = !this.condition;
  }

  // -------------------------------------

  people: string[] = [
    'Wezley',
    'Dave',
    'Iago',
    'Joe',
    'Nigel',
    'Nico',
    'John',
    'Max',
    'Lucas',
    'Gerard'
  ];

  monsters: any[] = [
    {
      name: 'Nessie',
      location: 'Loch Ness, Scotland'
    },
    {
      name: 'Bigfoot',
      location: 'Pacific Northwest, USA'
    },
    {
      name: 'Godzilla',
      location: 'Tokyo, Japan'
    }
  ]

  // ----------------------------------------------------

  time: string = '';

  changeTimeOfDay(desiredTime: string) {
    this.time = desiredTime;
  }

}
