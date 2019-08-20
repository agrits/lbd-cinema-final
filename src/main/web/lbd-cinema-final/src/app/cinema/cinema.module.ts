import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MoviesComponent } from './movies/movies.component';
import { RepertoireComponent } from './repertoire/repertoire.component';



@NgModule({
  declarations: [MoviesComponent, RepertoireComponent],
  imports: [
    CommonModule
  ]
})
export class CinemaModule { }
