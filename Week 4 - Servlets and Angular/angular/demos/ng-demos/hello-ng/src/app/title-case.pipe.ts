import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'titleCase'
})
export class TitleCasePipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if(!value) return null;

    let words: string[] = value.split(' ');

    for(let i = 0; i < words.length; i++) {
      let word = words[i];

      if(i > 0 && this.isPrepositions(word)) {
        words[i] = word.toLowerCase();
      } else {
        words[i] = (word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase());
      }
    }

    return words.join(' ');

  }

  private isPrepositions(word: string): boolean {
    let prepositions = ['of', 'in', 'over', 'the', 'a', 'with', 'through', 'is'];
    return prepositions.includes(word.toLowerCase());
  }

}
