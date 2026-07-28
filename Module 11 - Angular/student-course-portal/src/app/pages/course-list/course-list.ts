import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';

import { HighlightDirective } from '../../directives/highlight/highlight.directive';
import { CourseCardComponent } from '../../components/course-card/course-card';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCardComponent, HighlightDirective],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseListComponent implements OnInit {
  courses: Array<{
    id: number;
    name: string;
    code: string;
    credits: number | null;
    gradeStatus: 'passed' | 'failed' | 'pending';
    enrolled: boolean;
  }> = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed', enrolled: false },
    { id: 2, name: 'Web Development', code: 'CS102', credits: 3, gradeStatus: 'pending', enrolled: false },
    { id: 3, name: 'Database Systems', code: 'CS103', credits: 4, gradeStatus: 'failed', enrolled: false },
    { id: 4, name: 'Operating Systems', code: 'CS104', credits: 3, gradeStatus: 'passed', enrolled: false },
    { id: 5, name: 'Software Engineering', code: 'CS105', credits: null, gradeStatus: 'pending', enrolled: false }
  ];

  isLoading = true;

  selectedCourseId: number | null = null;

  ngOnInit(): void {
    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }

  trackByCourseId(index: number, course: { id: number }): number {
    // trackBy helps Angular reuse existing DOM nodes instead of re-rendering the full list.
    return course.id;
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
    this.courses = this.courses.map((course) =>
      course.id === courseId ? { ...course, enrolled: true } : course
    );
  }
}