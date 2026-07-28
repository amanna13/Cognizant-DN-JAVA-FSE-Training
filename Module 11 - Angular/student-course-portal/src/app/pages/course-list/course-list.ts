import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';

import { HighlightDirective } from '../../directives/highlight/highlight.directive';
import { CourseCardComponent } from '../../components/course-card/course-card';
import { CourseService } from '../../services/course.service';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCardComponent, HighlightDirective],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseListComponent implements OnInit {
  courses: Course[] = [];

  isLoading = true;

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    this.courses = this.courseService.getCourses();
    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }

  trackByCourseId(index: number, course: Course): number {
    // trackBy helps Angular reuse existing DOM nodes instead of re-rendering the full list.
    return course.id;
  }
}