import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MoviesComponent } from './movies/movies.component';
import { RepertoireComponent } from './repertoire/repertoire.component';
import { ReservationComponent } from './reservation/reservation.component';



@NgModule({
  declarations: [MoviesComponent, RepertoireComponent, ReservationComponent],
  imports: [
    CommonModule
  ]
})
export class CinemaModule { }
