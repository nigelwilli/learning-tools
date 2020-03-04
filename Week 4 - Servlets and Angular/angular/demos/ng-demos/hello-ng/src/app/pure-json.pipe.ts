import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pureJson',
  pure: false
})
export class PureJsonPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return JSON.stringify(value);
  }

}
