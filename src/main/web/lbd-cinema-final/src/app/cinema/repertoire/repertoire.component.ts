import { Component, OnInit } from '@angular/core';
import { ShowService } from 'src/app/data-services/show/show.service';
import { Show } from 'src/app/data-entity/show/show';
import { Movie } from 'src/app/data-entity/movies/movie';

@Component({
  selector: 'app-repertoire',
  templateUrl: './repertoire.component.html',
  styleUrls: ['./repertoire.component.css']
})
export class RepertoireComponent implements OnInit {

shows: Show[];
movies: Movie[];
  
  constructor(private showService:ShowService) { }

  ngOnInit() {
    this.showService.getLocalizations().subscribe(x => this.shows = x)
  }

}
