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
  ) {}
  private movies: Movie[];
  private subscribedMovies: any;
  private categories: Category[];
  private subscribedCategory: any;
  private lastMovieClicked: number = 0;
  private showMovieDescription: boolean = false;
  ngOnInit() {
    this.subscribedMovies = this.moviesService.getMovies().subscribe({
      next: movies => {
        this.movies = movies;
        this.subscribedMovies = movies;
        this.categoriesInitialization();
      },
      error: () => alert("Could not get any movies")
    });
  }
  private moviesCategoryInitialization() {
    this.movies.forEach(movie => {
      movie.category.name = this.categories.find(
        cat => cat.id === movie.category.id
      ).name;
    });
  }
  private movieDescriptionOnClick(movieToEdit) {
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
  private categoriesInitialization() {
    this.subscribedCategory = this.categoryService.getCategories().subscribe({
      next: categories => {
        this.categories = categories;
        this.subscribedCategory = categories;
        this.moviesCategoryInitialization();
      },
      error: () => alert("Could not get any categories")
    });
  }
}
