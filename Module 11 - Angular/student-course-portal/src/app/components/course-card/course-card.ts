import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-course-card',
  standalone: true,
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCardComponent implements OnChanges {
  @Input() course!: { id: number; name: string; code: string; credits: number };
  @Output() enrollRequested = new EventEmitter<number>();

  ngOnChanges(changes: SimpleChanges): void {
    const courseChange = changes['course'];

    if (courseChange) {
      console.log('Course input changed', {
        previousValue: courseChange.previousValue,
        currentValue: courseChange.currentValue
      });
    }
  }
}