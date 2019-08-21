import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MoviesService } from 'src/app/data-services/movies/movies.service';
import { Router } from '@angular/router';
import { Movie } from 'src/app/data-entity/movies/movie';
import { Category } from 'src/app/data-entity/category/category';
import { Subscription } from 'rxjs';
import { CategoryService } from 'src/app/data-services/category/category.service';

@Component({
  selector: 'app-create-movie',
  templateUrl: './create-movie.component.html',
  styleUrls: ['./create-movie.component.css']
})
export class CreateMovieComponent implements OnInit {

  addForm: FormGroup;
  submitted = false;
  movieService: MoviesService;

  categories: Category[];
  subscribedCategories: Subscription;
  selectedCategory: Category;

  constructor(private formBuilder: FormBuilder, private router: Router, movieService: MoviesService, private categoryService: CategoryService) {
    this.movieService = movieService;
   }

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      title: ['', [Validators.required, Validators.minLength(3)]],
      duration: ['', Validators.required],
      rating: ['', Validators.required],
      pegi: ['', Validators.required],
      category: ['', Validators.required],
      description: ['', Validators.required]
    });

    this.getCategory();
  }

  getCategory(){
    this.subscribedCategories = this.categoryService.getCategories().subscribe({
      next: (data) => this.categories = data,
      error: () => alert('Could not get any category')
    });
  }

  onCategoryChange(category: Category){
    this.selectedCategory = category;
    //console.log(this.selectedCategory)
  }

  onSubmit() {
    this.submitted = true;
    const result: Movie = Object.assign({}, this.addForm.value);
    if (this.addForm.invalid) {
      return;
    }
    console.log(result);
    this.movieService.createMovie(result).subscribe( data => {
        this.router.navigate(['/movies']);
      });
  }

  get title() { return this.addForm.get('title'); }
  get duration() { return this.addForm.get('duration'); }
  get rating() { return this.addForm.get('rating'); }
  get pegi() { return this.addForm.get('pegi'); }
  get category() { return this.addForm.get('category'); }
  get description() { return this.addForm.get('description'); }

}
