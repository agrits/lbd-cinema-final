import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MoviesComponent } from './movies/movies.component';
import { RepertoireComponent } from './repertoire/repertoire.component';
import { CreateMovieComponent } from './movies/create-movie/create-movie.component';
import { DeleteMovieComponent } from './movies/delete-movie/delete-movie.component';
import { UpdateMovieComponent } from './movies/update-movie/update-movie.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [MoviesComponent, RepertoireComponent, CreateMovieComponent, DeleteMovieComponent, UpdateMovieComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class CinemaModule { }
