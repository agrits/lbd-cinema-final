import { Component, OnInit } from "@angular/core";
import { MoviesService } from "src/app/data-services/movies/movies.service";
import { Movie } from "src/app/data-entity/movies/movie";
import { Category } from "src/app/data-entity/category/category";
import { CategoryService } from "src/app/data-services/category/category.service";

@Component({
  selector: "app-movies",
  templateUrl: "./movies.component.html",
  styleUrls: ["./movies.component.css"]
})
export class MoviesComponent implements OnInit {
  constructor(
    private moviesService: MoviesService,
    private categoryService: CategoryService
  ) { }


  movies: Movie[];
  subscribedMovies: any;
  categories: Category[];
  subscribedCategory: any;
  lastMovieClicked: Number = 0;
  showMovieDescription: boolean = false;


  ngOnInit() {
    this.subscribedMovies = this.moviesService.getMovies().subscribe({
      next: movies => {
        this.movies = movies;
        this.subscribedMovies = movies;
      },
      error: () => alert("Could not get any movies"),
      complete: () => this.moviesCategoryInitialization()
    });
  }

  private moviesCategoryInitialization() {
    this.movies.forEach(movie => {
      this.setMovieCategory(movie);
    });
  }

  private setMovieCategory(movie: Movie) {
    this.categoryService.getCategory(movie._links.category.href).subscribe({
      next: category => movie.category = category
    });
  }

  private movieDescriptionOnClick(movieToEdit: Movie) {
    console.log(movieToEdit);
    if (this.lastMovieClicked === movieToEdit.id) {
      this.showMovieDescription = !this.showMovieDescription;
    } else {
      if (this.showMovieDescription) {
        this.lastMovieClicked = movieToEdit.id;
      } else {
        this.lastMovieClicked = movieToEdit.id;
        this.showMovieDescription = !this.showMovieDescription;
      }
    }
  }

}
