import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';

import { CreditLabelPipe } from '../../pipes/credit-label/credit-label.pipe';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, CreditLabelPipe],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCardComponent implements OnChanges {
  @Input() course!: {
    id: number;
    name: string;
    code: string;
    credits: number | null;
    gradeStatus: 'passed' | 'failed' | 'pending';
    enrolled?: boolean;
  };
  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;

  ngOnChanges(changes: SimpleChanges): void {
    const courseChange = changes['course'];

    if (courseChange) {
      console.log('Course input changed', {
        previousValue: courseChange.previousValue,
        currentValue: courseChange.currentValue
      });
    }
  }

  get cardClasses(): Record<string, boolean> {
    // A getter keeps the template binding compact while still centralising class logic.
    return {
      'card--enrolled': !!this.course?.enrolled,
      'card--full': (this.course?.credits ?? 0) >= 4,
      expanded: this.isExpanded
    };
  }

  get borderColor(): string {
    if (this.course?.gradeStatus === 'passed') {
      return 'green';
    }

    if (this.course?.gradeStatus === 'failed') {
      return 'red';
    }

    return 'grey';
  }

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }
}