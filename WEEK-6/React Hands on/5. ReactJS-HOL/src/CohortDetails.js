import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails({ cohort }) {
  const isOngoing = cohort.currentStatus.toLowerCase() === 'ongoing';

  return (
    <div className={styles.box}>
      <h3 style={{ color: isOngoing ? 'green' : 'blue' }}>
        {cohort.cohortCode}
      </h3>
      <dl>
        <dt>Status:</dt>
        <dd>{cohort.currentStatus}</dd>

        <dt>Start Date:</dt>
        <dd>{cohort.startDate}</dd>

        <dt>End Date:</dt>
        <dd>{cohort.endDate || 'N/A'}</dd> 
      </dl>
    </div>
  );
}

export default CohortDetails;
